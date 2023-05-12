package org.cluo.framework.image.scale;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * In ImageHandleTest-test
 * <p>
 * Create in 14:33 2018/2/4
 *
 * @author canfuu
 * @version v1.0:say explain
 * @see ImageHandleUtilDemo
 */
public final class ImageHandleUtil {
	/**
	 * 根目录位置
	 */
	private static final String PATH = "";


	private static final BaseImageHandle FAST;
	private static final BaseImageHandle SMOOTH;
	private static final BaseImageHandle DEFAULT;
	private static final Lock L = new ReentrantLock();

	static {
		DEFAULT = new BaseImageHandle(Image.SCALE_DEFAULT, true) {
			@Override
			public void handle(String prefix, String from, String to, double p, int imageType, boolean doCompressed) throws IOException {
				ImageHandleUtil.handle(prefix, from, to, p, imageType, doCompressed);
			}
		};
		FAST = new BaseImageHandle(Image.SCALE_FAST, true) {
			@Override
			public void handle(String prefix, String from, String to, double p, int imageType, boolean doCompressed) throws IOException {
				ImageHandleUtil.handle(prefix, from, to, p, Image.SCALE_FAST, true);
			}
		};
		SMOOTH = new BaseImageHandle(Image.SCALE_SMOOTH, true) {
			@Override
			public void handle(String prefix, String from, String to, double p, int imageType, boolean doCompressed) throws IOException {
				ImageHandleUtil.handle(prefix, from, to, p, Image.SCALE_SMOOTH, true);
			}
		};
	}

	/**
	 * 平滑处理
	 * @param prefix 前缀
	 * @param from 来自
	 * @param to 给
	 * @param p 多少
     * @throws IOException IOException
	 */
	public static void smooth(String prefix, String from, String to, double p) throws IOException {
		SMOOTH.handle(prefix, from, to, p);
	}

	public static void fast(String prefix, String from, String to, double p) throws IOException {
		FAST.handle(prefix, from, to, p);
	}


	public static void auto(String prefix, String suffix) throws IOException {
		if (prefix != null && suffix != null) {
			if (!Character.valueOf('/').equals(prefix.charAt(prefix.length() - 1))) {
				prefix = prefix + "/";
			}
			if (Character.valueOf('/').equals(suffix.charAt(0))) {
				suffix = suffix.substring(1);
			}
			//原图压缩处理
			SMOOTH.handle(prefix, suffix, "op/" + suffix, -1.0);

			//普通图片处理
			SMOOTH.handle(prefix, suffix, "hd/" + suffix, 540.0);

			//缩略图片处理
			SMOOTH.handle(prefix, suffix, "sd/" + suffix, 180.0);
		}
	}


	public static BaseImageHandle newImageHandle(BaseImageHandle imageHandle) {
		return imageHandle;
	}

	public abstract static class BaseImageHandle {
		private int imageType;
		private boolean doCompressed;

		/**
		 * @param from 原图片相对路径
		 * @param to   输出图片相对路径
		 * @param p    图片分辨率尺寸
         * @param prefix prefix
		 * @throws IOException IOException
		 */
		public void handle(String prefix, String from, String to, double p) throws IOException {
			handle(prefix, from, to, p, this.imageType, this.doCompressed);
		}

		/**
		 * @param from         原图片相对路径
		 * @param to           输出图片相对路径
		 * @param p            图片分辨率尺寸
		 * @param imageType    图片类型，见Image中的int类型常量
		 * @param doCompressed 是否压缩
		 * @param prefix prefix
		 * @throws IOException IOException
		 * @see Image Image
		 */
		public abstract void handle(String prefix, String from, String to, double p, int imageType, boolean doCompressed) throws IOException;

		/**
		 * @param imageType    图片类型
		 * @param doCompressed 是否做处理
		 */
		public BaseImageHandle(int imageType, boolean doCompressed) {
			this.imageType = imageType;
			this.doCompressed = doCompressed;
		}
	}

	private static void handle(String prefix, String from, String to, double p, int imageType, boolean doCompressed) throws FileNotFoundException {
		String toImage = prefix + to;
		String fromImage = prefix + from;
		if (!new File(fromImage).exists()) {
			throw new FileNotFoundException(fromImage + "不存在");
		}
		try {
			Files.deleteIfExists(Paths.get(toImage));
			Files.createDirectories(Paths.get(toImage));
			Files.deleteIfExists(Paths.get(toImage));
			Image img = null;


			Path pp = Paths.get(fromImage);

			L.lock();
			try {
				img = ImageIO.read(Files.newInputStream(pp, CREATE_NEW));
			} catch (IOException ignored) {
				return;
			} finally {
				L.unlock();
			}

			int tempH = img.getHeight(null);
			int tempW = img.getWidth(null);

			Double s = (tempH > tempW ? tempW : tempH) / p;
			if (s < 1) {
				s = 1.0;
			}
			int w = ((Double) (img.getWidth(null) / s)).intValue();
			int h = ((Double) (img.getHeight(null) / s)).intValue();
			String suffix = toImage.substring(toImage.indexOf('.') + 1);
			BufferedImage image;
			if (suffix.equals("png")){
				image = new BufferedImage(w, h, Transparency.TRANSLUCENT);
			}else {
				image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			}
			if (doCompressed) {
				image.getGraphics().drawImage(img.getScaledInstance(w, h, imageType), 0, 0, null);
			}

			ImageIO.write(image, suffix, Files.newOutputStream(Paths.get(toImage), CREATE_NEW));
		} catch (IOException ignored) {
			ignored.printStackTrace();
		}
	}

	/**
	 * @param urlList 需要下载的文件的地址
	 * @param imageName 下载后保存的名称
	 * @return byte数组
	 */
	public static byte[] downloadPicture(String urlList, String imageName) {
		URL url = null;
		int imageNumber = 0;

		try {
			url = new URL(urlList);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());

			FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			byte[] context = output.toByteArray();
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
			return context;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public static String getImageBase64(String imgFile) {
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		//读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//对字节数组Base64编码
		return Base64.getEncoder().encodeToString(data);//返回Base64编码过的字节数组字符串
	}

}
