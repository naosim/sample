# SpringBoot + h2 + mybatisでHelloWorld
2018年に書いた下記記事の内容を2023年に動かしたときの差分です。  
SpringBoot + h2 + mybatisでHelloWorld - なおしむ論    
https://naosim.hatenablog.jp/entry/2018/11/28/074404


## SpringBootでHello
gradleの書き方と各種ライブラリのバージョンが変わっています。  
詳細は[こちら](https://github.com/naosim/sample/commit/848be74f85d4cd7feb163babde67cbed10096559)。  
差分は以下の通りです。
- gradle pluginはpluginsに直接記述するように変更
- dependenciesはcompileではなくimplementationに変更
- lombokはannotationProcessorを追加
- ライブラリのバージョンアップ。最新版は[MVNRepository](https://mvnrepository.com)でチェックしましょう。
javaのソースへの変更はありません。

## h2 + mybatis
ライブラリのバージョンとSQLの書き方が変わっています。  
詳細は[こちら](https://github.com/naosim/sample/commit/d73f3b3582cc2d643a1bce96cc72bbed22d82af5)。  
差分は以下の通りです。  
- ライブラリのバージョンアップ
- data.sqlの`sysdate`が使用不可。なくても問題ないのでdata.sqlを削除