9��4��    ��ʼ�������ڹ���

???
2017.9.8 附上代码说明，方便以后查看

全局使用MVP设计模式

Retrofit2（网络请求） + Gson（数据解析） + Glide（图片下载） 


请求参数数据格式为传Json对象



Model:

    常量类----Constant  
    请求接口类----IService,ICallBack
    视图接口类----IMainView
    请求层----DateModel
    
Present:
    逻辑处理-----Present
    

View：

    所有activity的命名都是以：功能+形式 方式命名  
    
    一、AdvActivity       轮播页面--------第一次安装APP时候显示，其他不显示，默认显示三张图，滑动到第三章的时候自动开启启动页面
    二、StartActivity     启动页面--------显示一张图片，1秒后自动跳转到登录页面
    三、MainActivity      登录页面--------
                                    1. 检查更新（如果不是第一次登录，不需要更新的时候会自动跳转到主界面）
                                    2. 输入手机号码，获取验证码，登录--跳转到主界面
    四、YeWuActivity      主界面----------主要由三个单选按钮组成
                        
                          1. 首页----ShouyeFragment  主界面由一个轮播、9个按钮，每个按钮对应一个功能页面
                                
                                  banner点击跳转一个web页面   WebActivity
                                
                                进件按钮--JinJianActivity  查询进件权限
                                
                                客户按钮--KuHuActivity     对应三个Fragment, 待进件---KeHuFragment, ---列表点击事件-----XiangQingActivity--JichuXinXiFragment
                                                                            
                                                                           已进件---KeHuFragment2,---列表点击事件-----FangKuanActivity
                                                                           
                                                                           已放款---KeHuFragment3,---列表点击事件-----FangKuanActivity
                                                                           
                                试算工具--ShiSuanActivity  
                                
                                个人业绩--GeRenYeJiActivity
                                
                                龙虎榜 ---LongHuBangActivity  对应三个Fragment.个人Top50 ---LongHuGeRenFragment 
                                                                            
                                                                                团队TOP10 ---LongHuTuanDuiFragment
                                                                             
                                                                                门店TOP5  ---LongHuMenDianFragment
                                                                             
                                公告栏---GongGaoActivity   列表展示数据-----点击事件---跳转WebActivity
                                
                                产品中心--ProductCenterActivity  三个按钮+H5显示
                                    
                         2. 更多-----GengDuoFragment 数据展示
                         
                         
                         
                         
                         
                                