# Highway-Datasharing-Platform平台搭建
一款基于若依的高速公路数据共享平台，新添了数据大屏。

## 系统环境要求

- JDK >= 1.8
- MySQL >= 5.7
- Maven >= 3.0
- Node >= 12
- Redis >= 3



## 后端运行

### 在开发工具（idea等）上拉取github远程仓库源码

![image-20250208213144212](C:\Users\18471\AppData\Roaming\Typora\typora-user-images\image-20250208213144212.png)

### 初始化工程

idea会自动加载`Maven`依赖包，初次加载会比较慢（根据自身网络情况而定）

![image-20231115113445187](C:\Users\18471\桌面\高速公路数据共享平台\笔记\assets\image-20231115113445187.png) 



### Mysql配置

#### 导入sql

1、创建数据库`create database ry;`

2、在数据库ry中执行下图的sql脚本文件

![](C:\Users\18471\AppData\Roaming\Typora\typora-user-images\image-20250208213523551.png) 

#### 配置文件

在`ruoyi-admin`模块下，修改数据库连接，编辑`resources`目录下的`application-druid.yml`

```yaml
# 数据源配置
spring:
    datasource:
        type: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.cj.jdbc.Driver
        druid:
            # 主库数据源
            master:
                url: 数据库地址（jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC）
                username: 数据库账号（一般为root）
                password: 数据库密码
```

### Redis配置

启动redis内存数据库

![](C:\Users\18471\AppData\Roaming\Typora\typora-user-images\image-20250208213759849.png) 

### 启动项目

在`ruoyi-admin`模块下，启动项目`com.ruoyi.RuoYiApplication.java`，出现如下图表示启动成功

![image-20231115114924549](C:\Users\18471\桌面\高速公路数据共享平台\笔记\assets\image-20231115114924549.png) 

后端运行成功可以通过([http://localhost:8080 )访问，但是不会出现静态页面，可以继续参考下面步骤部署`ruoyi-ui`前端，然后通过前端地址来访问。



## 前端运行

### 打开前端工程

通过idea打开前端工程

![image-20231115115726393](C:\Users\18471\桌面\高速公路数据共享平台\笔记\assets\image-20231115115726393.png) 

 

### 启动部署

在idea的Terminal命令窗口中执行以下命令

```shell
# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npmmirror.com

# 启动服务
npm run dev
```

打开浏览器，输入：([http://localhost:80) 默认账户/密码 `admin/admin123`）
若能正确展示登录页面，并能成功登录，菜单及页面展示正常，则表明运行成功
