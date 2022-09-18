# 博客网站

## 🚀项目表述

一个用于自己知识分享的个人博客系统让更多人了解你对知识的观点，主要用来发布博客，查看博客，个人介绍等等。

## 🍳技术栈

- 语言：java
- 后端框架：springboot
- 数据库：mysql
- 前端框架： vue
- 代码高亮：highlight



## 📷网站展示



![1](https://raw.githubusercontent.com/programzzp/blog/main/img/1.png)

![2](https://raw.githubusercontent.com/programzzp/blog/main/img/2.png)

![3](https://raw.githubusercontent.com/programzzp/blog/main/img/3.png)

![4](https://raw.githubusercontent.com/programzzp/blog/main/img/4.png)

![4](https://raw.githubusercontent.com/programzzp/blog/main/img/5.PNG)



项目地址：2022-9-15（到期） http://47.105.34.128   不支持手机访问



## 🔍部署说明:

## 数据库部署

### 1,docker搭建数据库

```bash
#安装mysql
#在mydata目录下新建conf与data 
docker run -d -p 3306:3306 -v /mydata/mysql/conf:/etc/mysql/conf.d -v /mydata/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root --name mysql mysql:5.7
```

### 2,将blog.sql导入MYSQL数据库中

```bash
#新建数据库(MYSQL) create database blog CHARACTER SET utf8 COLLATE utf8_general_ci;
create database blog CHARACTER SET utf8 COLLATE utf8_general_ci;
#导入数据
mysql -h ip -uroot –p blog < blog.sql
```



## 后端部署

### makefile编写

```makefile
### 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM java:8

#作者
MAINTAINER zhouzhanpei

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#应用构建成功后的jar文件被复制到镜像内，名字也改成了bolg.jar
ADD bolg_spring-1.0-SNAPSHOT.jar bolg.jar

#启动容器时的进程
ENTRYPOINT ["java","-jar","/bolg.jar"]

#暴露8088端口,这个端口对应的是服务本身的端口
EXPOSE 80
```



### 修改数据库配置

```bash
#bolg_spring/src/main/resources/application.yml 

#url: jdbc:mysql://url:port/blog?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
#url 为你自己数据库地址   port:端口号 

#打包java项目

docker build -f Dockerfile -t blog:1.0 .

docker run -d -p 8081:80 --name blog blog:1.0
```





## 前端部署

```bash
  
#前端修改后端
#blog/vue_blog/src/main.js 
#blog/vue_backstage/src/main.js
#axios.defaults.baseURL='http://url:port' 后端地址(需要修改地址)

#分别进入vue_blog与vue_backstage
cd vue_blog
cd vue_backstage
#下载依赖
npm install
#运行
npm run dev

#打包
npm run build

#部署nginx
#将static与index.html放如nginx\html文件夹下

```



```bash
#下载镜像
#docker安装nginx
#首先要cd到mydata文件夹下面，创建文件夹
mkdir nginx

#下载并启动
docker run -p 80:80 --name nginx -d nginx:1.10
#将容器内的配置文件拷贝到当前nginx目录（注意此时我们的位置在mydata文件夹下）
docker container cp nginx:/etc/nginx .
#停止nginx容器并删除nginx镜像
docker stop nginx
docker rm nginx
#重命名nginx文件夹为conf
mv nginx conf

#再次创建nginx文件夹
mkdir nginx
	
将conf移动到nginx
mv conf nginx/
#再次创建docker实例
docker run -p 80:80 --name nginx -v /mydata/nginx/html:/usr/share/nginx/html -v /mydata/nginx/logs:/var/log/nginx -v /mydata/nginx/conf:/etc/nginx -d nginx:1.10	
#设置开机启动
docker update nginx --restart=always


```

