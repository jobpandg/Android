1. tabLayout.setupWithViewPager 导致自定义tab布局失灵解决。

   https://www.jianshu.com/p/15d257af4a1c

2. 底部导航栏

   https://blog.csdn.net/zhangbiao0511/article/details/55511639

3. selector失灵原因

   https://www.jianshu.com/p/b44e1cfcce04

   这是imageView src 的selector， 在tabLayout和viewPager 绑定之前（tabLayout.setupWithViewPager），如果不设置imageview =>android:clickable='true'那么就不能在点击之后保持状态，但是绑定之后，点击tab上面的imageview 也不行，但是点击tab上除了imageview也行，这是因为imageview设置为clickable之后那么就需要点击好几次

4. tab点击去除水波效果

```
app:tabBackground="@android:color/transparent"
```

5. 