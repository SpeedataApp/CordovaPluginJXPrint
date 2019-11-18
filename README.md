# README

### 文件说明

* printTest 为Cordova创建的测试程序 步骤如下

  ```
  1.cordova create printTest com.speedata.cordova.printTest  #创建printTest项目
  2.cordova platform add android  #添加Android平台
  3.cordova build  #先编译看下自己环境有没有问题
  4cordova plugin add /$PATH$/JXPrintPlugin #添加打印的插件,$PATH$为插件所在目录
  5.替换index.html  #index.html为测试调用界面 
  6.cordova build 
  ```

​       测试环境

```
Cordova 9.0.0 (cordova-lib@9.0.1)
android 8.1.0
```





* JXPrintPlugin 插件
* JXPrintPlugin插件接口说明   JXPrintPlugin.js方法说明
* JXPrintTest.apk  Android测试程序