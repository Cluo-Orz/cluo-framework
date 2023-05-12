package org.cluo.framework.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author canfuu.cts
 * @class QrCodeUtil
 * @date 2023/5/13 00:55
 */
public class QrCodeUtil {


    public static byte[] createQrCode(String data) throws IOException, WriterException {
        return createQrCode(data, 2);
    }

    public static byte[] createQrCode(String data, Integer margin) throws IOException, WriterException {
        int width = 300;
        int height = 300;
        //定义二维码的参数
        HashMap<EncodeHintType, Object> map = new HashMap();
        //设置编码
        map.put(EncodeHintType.CHARACTER_SET, "GB2312");
//        设置纠错等级
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        map.put(EncodeHintType.MARGIN, margin);
        //生成二维码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, map);

        BufferedImage bi = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", out);
        return out.toByteArray();
    }

}
