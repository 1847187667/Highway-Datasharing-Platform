create database if not exists ry;
use ry;
-- 创建气象数据表
CREATE TABLE MeteorologicalData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    temperature DECIMAL(5, 1), -- 温度
    humidity INT, -- 湿度 %
    wind_speed INT, -- 风速 km/h
    rainfall INT, -- 雨量 mm
    snowfall INT, -- 雪量 mm
    extreme_weather_warning TEXT, -- 极端天气预警
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk1 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);

-- 创建交通状态数据表
CREATE TABLE TrafficStatus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    traffic_volume INT, -- 实时交通流量
    average_speed INT, -- 车速
    congestion_description TEXT, -- 拥堵状况
    vehicle_type_distribution TEXT, -- 车辆类型分布
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk2 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);

-- 创建事故数据表
CREATE TABLE AccidentData (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accident_time DATETIME, -- 事故时间
    accident_location TEXT, -- 事故地点
    accident_type TEXT, -- 事故类型
    involved_vehicles TEXT, -- 涉及车辆
    casualties INT, -- 伤亡情况
    image LONGBLOB, -- 现场图片
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk3 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);

-- 创建交通管制数据表
CREATE TABLE TrafficControl (
    id INT AUTO_INCREMENT PRIMARY KEY,
    control_start_time DATETIME, -- 管制开始时间
    control_end_time DATETIME, -- 管制结束时间
    control_location TEXT, -- 管制路段
    control_reason TEXT, -- 管制原因
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk4 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);

-- 创建维护和施工信息表
CREATE TABLE MaintenanceInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    maintenance_start_time DATETIME, -- 施工开始时间
    maintenance_end_time DATETIME, -- 施工预计结束时间
    maintenance_location TEXT, -- 施工地点
    maintenance_type TEXT, -- 施工性质
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk5 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);

-- 创建紧急事件数据表
CREATE TABLE EmergencyEvents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_time DATETIME, -- 事件时间
    event_type TEXT, -- 事件类型
    event_location TEXT, -- 事件地点
    event_description TEXT, -- 事件描述
    image LONGBLOB, -- 现场图片
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
    dept_id BIGINT, -- 提供数据的部门id
    constraint dept_id_fk6 foreign key (dept_id) references sys_dept (dept_id) -- 添加外键约束
);