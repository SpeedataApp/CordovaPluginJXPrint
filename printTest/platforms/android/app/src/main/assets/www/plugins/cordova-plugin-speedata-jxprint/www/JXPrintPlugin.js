cordova.define("cordova-plugin-speedata-jxprint.JXPrintPlugin", function(require, exports, module) {
var JXPrintPlugin = {
    coolMethod: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'coolMethod', arg0);
    },
    connectPrinter: function (success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'connectPrinter', []);
    },
    closeConnect: function (success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'closeConnect', []);
    },
    setPaperType: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setPaperType', arg0);
    },
    setDensity: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setDensity', arg0);
    },
    setPaperFeed: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setPaperFeed', arg0);
    },
    setPaperBack: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setPaperBack', arg0);
    },
    printSelfCheck: function (success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'printSelfCheck', []);
    },
    printText: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'printText', arg0);
    },
    sendBytesData: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'sendBytesData', arg0);
    },
    read: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'read', arg0);
    },
    initPrinter: function (success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'initPrinter', []);
    },
    setFont: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setFont', arg0);
    },
    setPrinter: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'setPrinter', arg0);
    },
    printBarCode: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'printBarCode', arg0);
    },
    printImage: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'printImage', arg0);
    },
    printTable: function (success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'printTable', []);
    },
    createTable: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'createTable', arg0);
    },
    addRow: function (arg0, success, error) {
        cordova.exec(success, error, 'JXPrintPlugin', 'addRow', arg0);
    }
}
module.exports = JXPrintPlugin;
});
