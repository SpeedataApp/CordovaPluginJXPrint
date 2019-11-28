cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "cordova-plugin-lpapi.LPAPIPlugin",
      "file": "plugins/cordova-plugin-lpapi/www/android/LPAPIPlugin.js",
      "pluginId": "cordova-plugin-lpapi",
      "clobbers": [
        "LPAPIPlugin"
      ]
    },
    {
      "id": "cordova-plugin-lpapi.lpapiModel",
      "file": "plugins/cordova-plugin-lpapi/www/ios/lpapiModel.js",
      "pluginId": "cordova-plugin-lpapi",
      "clobbers": [
        "lpapiModel"
      ]
    },
    {
      "id": "cordova-plugin-lpapi.LPAPI",
      "file": "plugins/cordova-plugin-lpapi/www/LPAPI.js",
      "pluginId": "cordova-plugin-lpapi",
      "clobbers": [
        "LPAPI"
      ]
    },
    {
      "id": "cordova-plugin-speedata-jxprint.JXPrintPlugin",
      "file": "plugins/cordova-plugin-speedata-jxprint/www/JXPrintPlugin.js",
      "pluginId": "cordova-plugin-speedata-jxprint",
      "clobbers": [
        "JXPrintPlugin"
      ]
    }
  ];
  module.exports.metadata = {
    "cordova-plugin-whitelist": "1.3.4",
    "cordova-plugin-lpapi": "1.0.4",
    "cordova-plugin-speedata-jxprint": "1.0.2"
  };
});