Android 基于 PagerSlidingTabStrip 改造的自定义导航栏。完美兼容 Android 自带库和兼容库的ViewPager组件，和ViewPager配合的页面指示器。

1.属性介绍

基本属性：
 * pstsIndicatorColor Tab底部选中的指示器的颜色
 * pstsUnderlineColor Tab底部指示器的颜色
 * pstsDividerColor Tab间的分割线的颜色
 * pstsSelectedTabTextColor Tab选中的文字的颜色
 * pstsTabTextColor Tab文字的颜色
 * pstsDotColor Tab的指示点的颜色
 * pstsTabBackground Tab的背景色
 * pstsIndicatorHeight Tab底部选中的指示器的高度
 * pstsUnderlineHeight Tab底部指示器的高度
 * pstsDividerPadding Tab间的分割线的上下padding
 * pstsDividerWidth Tab间的分割线的宽度
 * pstsTabPaddingLeftRight Tab的左右padding
 * pstsScrollOffset Tab底部指示器相对被选中的标签的偏移
 * pstsTabTextSize Tab的文字大小
 * pstsPaddingTop Tab的上边距
 * pstsPaddingBottom Tab的下边距
 * pstsShouldExpand Tab是否自动填充满屏幕
 * pstsTextAllCaps Tab文字大小写
 * pstsIndicatorinFollower Tab底部指示器是否跟文字宽度一致
 
扩展属性：
 * setIconAndText 设置布局样式，图文展示（TABICONTEXT 图标加文本；TABICON 图标；TABTEXT 文本）
 * setNormalIconRes 设置未选择的图标
 * setLightIconRes 设置已选择的图标
 * setTabTexts 设置文本
 * setDot 设置指示点  注意：此方法必须在设置ViewPager后调用
 
2.引用介绍

（1）gradle 

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Add the dependency:

	dependencies {
	        implementation 'com.github.qinjie0513:PagerSlidingTabStrip:1.0.1'
	}

（2）maven 

Add the JitPack repository to your build file 

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
Add the dependency

	<dependency>
	    <groupId>com.github.qinjie0513</groupId>
	    <artifactId>PagerSlidingTabStrip</artifactId>
	    <version>1.0.1</version>
	</dependency>

3.代码详解

xml属性设置效果

	<com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip
            android:id="@+id/pagerSlidingTabStrip"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/color_ffffff"
            android:layout_centerInParent="true"
            app:pstsIndicatorColor="@color/color_1897F2"
            app:pstsUnderlineColor="@android:color/transparent"
            app:pstsDividerColor="@android:color/transparent"
            app:pstsSelectedTabTextColor="@color/color_1897F2"
            app:pstsTabTextColor="@color/color_313131"
            app:pstsDotColor="@color/color_FF3300"
            app:pstsTabBackground="@android:color/transparent"
            app:pstsIndicatorHeight="2dp"
            app:pstsUnderlineHeight="0dp"
            app:pstsDividerPadding="2dp"
            app:pstsDividerWidth="0dp"
            app:pstsTabPaddingLeftRight="20dp"
            app:pstsScrollOffset="0dp"
            app:pstsTabTextSize="16sp"
            app:pstsPaddingTop="10dp"
            app:pstsPaddingBottom="10dp"
            app:pstsShouldExpand="true"
            app:pstsTextAllCaps="false"
            app:pstsIndicatorinFollower="true" />
			
java代码设置效果

	private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0);
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0);
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true);
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true);
    }
	
kotlin代码设置效果

	private fun setTabsValue() {
        val dm = resources.displayMetrics
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL)
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(resources.getColor(R.color.color_1897F2))
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT)
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT)
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(resources.getColor(R.color.color_1897F2))
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(resources.getColor(R.color.color_313131))
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(resources.getColor(R.color.color_FF3300))
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT)
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm).toInt())
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0)
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0)
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0)
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm).toInt())
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0)
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, dm).toInt())
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true)
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false)
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true)
    }

界面代码示例    文本

public class TabTextActivity extends AppCompatActivity implements TabTextPagerAdapter.TabPagerListener {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    private TabTextPagerAdapter mAdapter;

    private final String[] mTitles = {"Tab0", "Tab1", "Tab2", "Tab3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        setTabsValue();
        initViewPager();
    }

    private void initViews() {
        mPagerSlidingTabStrip = findViewById(R.id.pagerSlidingTabStrip);
        mViewPager = findViewById(R.id.viewPager);
    }

    private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0);
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0);
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true);
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true);
    }

    private void initViewPager() {
        mAdapter = new TabTextPagerAdapter(getSupportFragmentManager(), 4, mTitles);
        mAdapter.setListener(this);
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);

        mPagerSlidingTabStrip.setDot(0, true);
        mPagerSlidingTabStrip.setDot(2, true);
        //mPagerSlidingTabStrip.clearAllDots();
    }

    @Override
    public Fragment getFragment(int position) {
        return ExampleFragment.newInstance(position);
    }

}

界面代码示例    图片

public class TabIconActivity extends AppCompatActivity implements TabIconPagerAdapter.TabPagerListener {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    private TabIconPagerAdapter mAdapter;

    private final int[] mIconDefault = {R.mipmap.icon_home, R.mipmap.icon_financing, R.mipmap.icon_study, R.mipmap.icon_person};
    private final int[] mIconChoosed = {R.mipmap.icon_home_pre, R.mipmap.icon_financing_pre, R.mipmap.icon_study_pre, R.mipmap.icon_person_pre};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        setTabsValue();
        initViewPager();
    }

    private void initViews() {
        mPagerSlidingTabStrip = findViewById(R.id.pagerSlidingTabStrip);
        mViewPager = findViewById(R.id.viewPager);
    }

    private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0);
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0);
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true);
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true);

        //设置未选择的图标
        mPagerSlidingTabStrip.setNormalIconRes(mIconDefault);
        //设置已选择的图标
        mPagerSlidingTabStrip.setLightIconRes(mIconChoosed);
    }

    private void initViewPager() {
        mAdapter = new TabIconPagerAdapter(getSupportFragmentManager(), 4, mIconChoosed);
        mAdapter.setListener(this);
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    @Override
    public Fragment getFragment(int position) {
        return ExampleFragment.newInstance(position);
    }

}

界面代码示例    图文

public class TabIconTextActivity extends AppCompatActivity implements TabIconTextPagerAdapter.TabPagerListener {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    private TabIconTextPagerAdapter mAdapter;

    private final String[] mTitles = {"Tab0", "Tab1", "Tab2", "Tab3"};
    private final int[] mIconDefault = {R.mipmap.icon_home, R.mipmap.icon_financing, R.mipmap.icon_study, R.mipmap.icon_person};
    private final int[] mIconChoosed = {R.mipmap.icon_home_pre, R.mipmap.icon_financing_pre, R.mipmap.icon_study_pre, R.mipmap.icon_person_pre};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        setTabsValue();
        initViewPager();
    }

    private void initViews() {
        mPagerSlidingTabStrip = findViewById(R.id.pagerSlidingTabStrip);
        mViewPager = findViewById(R.id.viewPager);
    }

    private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0);
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0);
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true);
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true);

        //设置布局样式
        mPagerSlidingTabStrip.setIconAndText(PagerSlidingTabStrip.TABICONTEXT);
        //设置文本
        mPagerSlidingTabStrip.setTabTexts(mTitles);
        //设置未选择的图标
        mPagerSlidingTabStrip.setNormalIconRes(mIconDefault);
        //设置已选择的图标
        mPagerSlidingTabStrip.setLightIconRes(mIconChoosed);
    }

    private void initViewPager() {
        mAdapter = new TabIconTextPagerAdapter(this, getSupportFragmentManager(), 4, R.layout.view_tab_icon_text);
        mAdapter.setListener(this);
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    @Override
    public Fragment getFragment(int position) {
        return ExampleFragment.newInstance(position);
    }

}

注意：三种适配器已在源码封装好，可下载源码查看。









 
