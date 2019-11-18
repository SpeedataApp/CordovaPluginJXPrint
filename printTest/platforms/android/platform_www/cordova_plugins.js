cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "cordova-plugin-speedata-jxprint.JXPrintPlugin",
      "file": "plugins/cordova-plugin-speedata-jxprint/www/JXPrintPlugin.js",
      "pluginId": "cordova-plugin-speedata-jxprint",
      "clobbers": [
        "cordova.plugins.JXPrintPlugin"
      ]
    }
  ];
  module.exports.metadata = {
    "cordova-plugin-whitelist": "1.3.4",
    "cordova-plugin-speedata-jxprint": "1.0.1"
  };
});