# Tlias Web 管理系统

## 项目简介

Tlias Web 管理系统是一个基于 Spring Boot 的企业级管理系统，提供了班级、部门、员工、学生等核心业务模块的管理功能，同时集成了文件上传、数据报表等扩展功能。

## 技术栈

- **后端框架**：Spring Boot 4.0.3
- **ORM 框架**：MyBatis
- **数据库**：MySQL
- **认证方式**：JWT
- **文件存储**：阿里云 OSS
- **日志管理**：AOP 操作日志
- **分页插件**：PageHelper

## 项目结构

```
src/
├── main/
│   ├── java/com/juzixiong/
│   │   ├── anno/           # 自定义注解
│   │   ├── aop/            # AOP 切面
│   │   ├── config/         # 配置类
│   │   ├── controller/     # 控制器
│   │   ├── exception/      # 异常处理
│   │   ├── filter/         # 过滤器
│   │   ├── interceptor/    # 拦截器
│   │   ├── mapper/         # 数据访问层
│   │   ├── pojo/           # 实体类
│   │   ├── service/        # 业务逻辑层
│   │   ├── util/           # 工具类
│   │   ├── utils/          # 工具类
│   │   └── TliasWebManagementApplication.java  # 应用主类
│   └── resources/
│       ├── com/juzixiong/mapper/  # MyBatis XML 映射文件
│       ├── static/          # 静态资源
│       ├── application.yml  # 应用配置
│       └── logback.xml      # 日志配置
└── test/                   # 测试代码
```

## 核心功能模块

### 1. 认证模块
- 登录认证（JWT token 生成）
- Token 验证（拦截器和过滤器实现）

### 2. 部门管理
- 部门列表查询
- 部门添加、修改、删除

### 3. 员工管理
- 员工列表查询（支持分页）
- 员工添加、修改、删除
- 员工详情查看

### 4. 班级管理
- 班级列表查询
- 班级添加、修改、删除

### 5. 学生管理
- 学生列表查询
- 学生添加、修改、删除

### 6. 文件上传
- 支持文件上传到阿里云 OSS

### 7. 报表管理
- 数据报表生成

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 5.7+

### 配置步骤
1. 克隆项目到本地
2. 修改 `application.yml` 中的数据库连接信息
3. 修改阿里云 OSS 配置信息（如果需要使用文件上传功能）
4. 执行数据库脚本，创建相关表结构

### 运行项目
```bash
# 编译项目
mvn clean package

# 运行项目
mvn spring-boot:run
```

### 访问地址
项目启动后，可通过以下地址访问：
- 项目基础路径：`http://localhost:8080`
- 登录接口：`POST /login`

## API 接口说明

### 认证接口
- `POST /login` - 用户登录，返回 JWT token

### 部门管理接口
- `GET /depts` - 获取部门列表
- `POST /depts` - 添加部门
- `PUT /depts/{id}` - 修改部门
- `DELETE /depts/{id}` - 删除部门

### 员工管理接口
- `GET /emps` - 获取员工列表（支持分页）
- `POST /emps` - 添加员工
- `PUT /emps/{id}` - 修改员工
- `DELETE /emps/{id}` - 删除员工
- `GET /emps/{id}` - 获取员工详情

### 班级管理接口
- `GET /clazzes` - 获取班级列表
- `POST /clazzes` - 添加班级
- `PUT /clazzes/{id}` - 修改班级
- `DELETE /clazzes/{id}` - 删除班级

### 学生管理接口
- `GET /students` - 获取学生列表
- `POST /students` - 添加学生
- `PUT /students/{id}` - 修改学生
- `DELETE /students/{id}` - 删除学生

### 文件上传接口
- `POST /upload` - 上传文件到阿里云 OSS

### 报表管理接口
- `GET /reports` - 获取报表数据

## 注意事项

1. 项目使用 JWT 进行认证，登录后需要在请求头中携带 `Authorization` 字段，值为 `Bearer {token}`
2. 文件上传功能依赖阿里云 OSS，需要配置正确的 OSS 信息
3. 项目使用 PageHelper 进行分页，默认分页参数为 `pageNum` 和 `pageSize`

## 许可证

本项目采用 MIT 许可证。
