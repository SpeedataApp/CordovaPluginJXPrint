package cordova.plugin.speedata.jxprint;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import com.spd.print.jx.impl.PrintImpl;
import com.spd.print.jx.inter.IConnectCallback;
import com.spd.print.jx.utils.StringUtils;
import com.printer.sdk.Barcode;
import com.printer.sdk.Table;
import com.printer.sdk.PrinterConstants;
import com.speedata.libutils.DataConversionUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;
import android.content.Context;
import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class JXPrintPlugin extends CordovaPlugin {
    private CallbackContext callbackContext;
    private PrintImpl mPrinterImpl;
    private Context mContext;
    public Boolean isConnection = false;
    private Table table;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        mContext = webView.getContext();
        mPrinterImpl = new PrintImpl();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } else if (action.equals("connectPrinter")) {
            this.connectPrinter(callbackContext);
            return true;
        } else if (action.equals("closeConnect")) {
            this.closeConnect(callbackContext);
            return true;
        } else if (action.equals("setPaperType")) {
            this.setPaperType(args, callbackContext);
            return true;
        } else if (action.equals("setDensity")) {
            this.setDensity(args, callbackContext);
            return true;
        } else if (action.equals("setPaperFeed")) {
            this.setPaperFeed(args, callbackContext);
            return true;
        } else if (action.equals("setPaperBack")) {
            this.setPaperBack(args, callbackContext);
            return true;
        } else if (action.equals("printSelfCheck")) {
            this.printSelfCheck(callbackContext);
            return true;
        } else if (action.equals("printText")) {
            this.printText(args, callbackContext);
            return true;
        } else if (action.equals("sendBytesData")) {
            this.sendBytesData(args, callbackContext);
            return true;
        } else if (action.equals("read")) {
            this.read(args, callbackContext);
            return true;
        } else if (action.equals("initPrinter")) {
            this.initPrinter(callbackContext);
            return true;
        } else if (action.equals("setFont")) {
            this.setFont(args, callbackContext);
            return true;
        } else if (action.equals("setPrinter")) {
            this.setPrinter(args, callbackContext);
            return true;
        } else if (action.equals("printBarCode")) {
            this.printBarCode(args, callbackContext);
            return true;
        } else if (action.equals("printImage")) {
            this.printImage(args, callbackContext);
            return true;
        } else if (action.equals("printTable")) {
            this.printTable(callbackContext);
            return true;
        } else if (action.equals("createTable")) {
            this.createTable(args, callbackContext);
            return true;
        } else if (action.equals("addRow")) {
            this.addRow(args, callbackContext);
            return true;
        }
        return false;
    }

    private void connectPrinter(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        IConnectCallbackImpl callbackImpl = new IConnectCallbackImpl();
        mPrinterImpl.connectPrinter(callbackImpl);
    }

    private void closeConnect(CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        mPrinterImpl.closeConnect();
    }

    private void setPaperType(JSONArray args, CallbackContext callbackContext) {
        try {
            int paperType = args.getInt(0);
            mPrinterImpl.setPaperType(paperType);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void setDensity(JSONArray args, CallbackContext callbackContext) {
        try {
            int density = args.getInt(0);
            mPrinterImpl.setDensity(density);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void setPaperFeed(JSONArray args, CallbackContext callbackContext) {
        try {
            int line = args.getInt(0);
            mPrinterImpl.setPaperFeed(line);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void setPaperBack(JSONArray args, CallbackContext callbackContext) {
        try {
            int line = args.getInt(0);
            mPrinterImpl.setPaperBack(line);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void printSelfCheck(CallbackContext callbackContext) {
        try {
            mPrinterImpl.printSelfCheck();
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void printText(JSONArray args, CallbackContext callbackContext) {
        try {
            String text = args.getString(0);
            mPrinterImpl.printText(text);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void sendBytesData(JSONArray args, CallbackContext callbackContext) {
        try {
            String hexString = args.getString(0);
            byte[] bytes = DataConversionUtils.HexString2Bytes(hexString);
            mPrinterImpl.sendBytesData(bytes);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void read(JSONArray args, CallbackContext callbackContext) {
        try {
            String hexString = args.getString(0);
            byte[] bytes = DataConversionUtils.HexString2Bytes(hexString);
            int res = mPrinterImpl.read(bytes);
            if (res > 0) {
                callbackContext.success("success:" + DataConversionUtils.byteArrayToString(bytes));
            } else {
                callbackContext.error("error:" + res);
            }
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void initPrinter(CallbackContext callbackContext) {
        try {
            mPrinterImpl.initPrinter();
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void setFont(JSONArray args, CallbackContext callbackContext) {
        try {
            int mCharacterType = args.getInt(0);
            int mWidth = args.getInt(1);
            int mHeight = args.getInt(2);
            int mBold = args.getInt(3);
            int mUnderline = args.getInt(4);
            mPrinterImpl.setFont(mCharacterType, mWidth, mHeight, mBold, mUnderline);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void setPrinter(JSONArray args, CallbackContext callbackContext) {
        try {
            int command = args.getInt(0);
            int value = args.getInt(1);
            mPrinterImpl.setPrinter(command, value);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void printBarCode(JSONArray args, CallbackContext callbackContext) {
        try {
            byte[] bytesType = new byte[] { BarcodeType.CODE128, BarcodeType.CODE39, BarcodeType.CODABAR,
                    BarcodeType.ITF, BarcodeType.CODE93, BarcodeType.UPC_A, BarcodeType.UPC_E, BarcodeType.JAN13,
                    BarcodeType.JAN8, BarcodeType.QRCODE, BarcodeType.PDF417, BarcodeType.DATAMATRIX };
            int type = args.getInt(0);
            int width = args.getInt(1);
            int height = args.getInt(2);
            int param3 = args.getInt(3);
            String content = args.getString(4);
            Barcode barcode = null;
            if (type >= 0 && type <= 8) {
                barcode = new Barcode(bytesType[type], width, height, 2, content);
            } else if (type >= 9 && type <= 11) {
                barcode = new Barcode(bytesType[type], width, height, 6, content);
            } else {
                callbackContext.error("error: type is 0~11");
            }
            mPrinterImpl.printBarCode(barcode);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void printImage(JSONArray args, CallbackContext callbackContext) {
        try {
            String path = args.getString(0);
            int alignType = args.getInt(1);
            int left = args.getInt(2);
            boolean isCompressed = args.getBoolean(3);
            String str = Environment.getExternalStorageDirectory() + File.separator + path;
            Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + File.separator + path);
            Matrix matrix = new Matrix();
            matrix.setScale(1f, 1f);
            Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            mPrinterImpl.printBigImage(resizeBmp, alignType, left, isCompressed);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void printTable(CallbackContext callbackContext) {
        try {
            mPrinterImpl.printTable(this.table);
            callbackContext.success("success");
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void createTable(JSONArray args, CallbackContext callbackContext) {
        try {
            String column = args.getString(0);
            String separator = args.getString(1);
            String columnWidth = args.getString(2);
            if (columnWidth != null) {
                int n = columnWidth.split(",").length;
                String[] widthStr = columnWidth.split(",");
                int[] width = new int[n];
                for (int i = 0; i < n; i++) {
                    width[i] = Integer.parseInt(widthStr[i]);
                }
                this.table = new Table(column, separator, width);
            } else {
                this.table = new Table(column, separator, null);
            }
            callbackContext.success("success");
        } catch (Exception e) {
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void addRow(JSONArray args, CallbackContext callbackContext) {
        try {
            String tableRow = args.getString(0);
            if (this.table != null) {
                this.table.addRow(tableRow);
                callbackContext.success("success");
            } else {
                callbackContext.error("error: table is null!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            callbackContext.error("error:" + Log.getStackTraceString(e));
        }
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    class IConnectCallbackImpl implements IConnectCallback {
        @Override
        public void onPrinterConnectSuccess() {
            isConnection = true;
            callbackContext.success("Successful connection");
        }

        @Override
        public void onPrinterConnectFailed(int errorCode) {
            isConnection = false;
            if (errorCode == 103) {
                callbackContext.error("Disconnected");
            } else {
                callbackContext.error("Failed" + errorCode);
            }
        }
    }

    public static class BarcodeType {
        public static final byte UPC_A = 0;
        public static final byte UPC_E = 1;
        public static final byte JAN13 = 2;
        public static final byte JAN8 = 3;
        public static final byte CODE39 = 4;
        public static final byte ITF = 5;
        public static final byte CODABAR = 6;
        public static final byte CODE93 = 72;
        public static final byte CODE128 = 73;
        public static final byte PDF417 = 100;
        public static final byte DATAMATRIX = 101;
        public static final byte QRCODE = 102;

        public BarcodeType() {
        }
    }
}
