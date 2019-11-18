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
    }
}
module.exports = JXPrintPlugin;