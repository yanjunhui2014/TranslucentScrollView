## TranslucentScrollView

   效果如图：
   ![image](https://github.com/yanjunhui2014/TranslucentScrollView/blob/master/TranslucentScrollView/gif/device-2016-12-26-192438.gif)
   
   用法请参见
   ![doc](https://github.com/yanjunhui2014/TranslucentScrollView/blob/master/TranslucentScrollView/app/src/main/java/com/milo/demo/ui/SecondDemoActivity.java)
   
   主要API
   
   ```
    //设置HeaderView（也就是拉伸区域）
    PullZoomView.setHeaderView(R.layout.view_header);
    //设置普通（追加）视图，可以添加多个
    PullZoomView.addNormalView(R.layout.view_normal, R.layout.view_normal);
	//设置阻力系数
	PullZoomView.setDamping(0.2f, 0);
    
    //关联渐变视图 - 可选
    PullZoomView.attachTransView(mActionBar, getResources().getColor(R.color.colorPrimary), -1, -1);
    //设置透明度变化监听 - 可选
    PullZoomView.setTranslucentChangedListener(new TranslucentScrollView.TranslucentChangedListener() {
          @Override
          public void onTranslucentChanged(int transAlpha) {
               //回调alpah值，0-255
          }
     });
     //隐藏ScrollBar - 可选
     PullZoomView.mLayoutTransSV.setVerticalScrollBarEnabled(false);
   ```