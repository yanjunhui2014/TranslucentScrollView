# TranslucentScrollView
自定义ScrollView实现Toolbar（标题栏）渐变

效果如图：
![image](https://github.com/yanjunhui2014/TranslucentScrollView/blob/master/TranslucentScrollView/gif/device-2016-12-26-192438.gif)

编程思想：

1、自定义一个类，继承自ScrollView，并重写它的 onScrollChanged 方法；

2、在 onScrollChanged 中获取 ScrollView 在Y轴的移动距离，并根据此距离改变 Toolbar(标题栏) 的透明度。
