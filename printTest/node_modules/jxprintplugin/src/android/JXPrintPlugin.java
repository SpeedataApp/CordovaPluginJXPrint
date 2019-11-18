package cordova.plugin.speedata.jxprint;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import com.spd.print.jx.impl.PrintImpl;
import com.spd.print.jx.inter.IConnectCallback;
import android.util.Log;
import android.content.Context;

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
            callbackContext.error("Connection failed");
        }
    }
}
