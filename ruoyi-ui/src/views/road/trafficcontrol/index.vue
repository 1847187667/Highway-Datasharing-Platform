<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" >
      <el-form-item label="管制开始时间" prop="controlStartTime" label-width="100px">
        <el-date-picker clearable
          v-model="queryParams.controlStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择管制开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="管制结束时间" prop="controlEndTime" label-width="100px">
        <el-date-picker clearable
          v-model="queryParams.controlEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择管制结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="管制路段" prop="controlLocation">
          <el-select v-model="queryParams.controlLocation" placeholder="请选择交通管制路段">
            <el-option
              v-for="dict in dict.type.location"
              :key="dict.value"
              :label="dict.label"
              :value="dict.label"
            ></el-option>
          </el-select>
        </el-form-item>
      <el-form-item label="数据来源" prop="deptId" label-width="80px">
        <el-select v-model="queryParams.deptId" placeholder="请选择提供数据部门" clearable>
          <el-option
            v-for="dict in dict.type.dept_id"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['road:trafficcontrol:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['road:trafficcontrol:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['road:trafficcontrol:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['road:trafficcontrol:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="trafficcontrolList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" width="55">
        <template slot-scope="scope">
          {{ (queryParams.pageNum - 1) * queryParams.pageSize + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="管制开始时间" align="center" prop="controlStartTime" width="280">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.controlStartTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="管制结束时间" align="center" prop="controlEndTime" width="250">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.controlEndTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="管制路段" align="center" prop="controlLocation" />
      <el-table-column label="管制原因" align="center" prop="controlReason" />
      <el-table-column label="更新时间" align="center" prop="updatedAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updatedAt, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="数据来源" align="center" prop="deptId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.dept_id" :value="scope.row.deptId"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['road:trafficcontrol:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['road:trafficcontrol:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改交通管制数据管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="管制开始时间" prop="controlStartTime">
          <el-date-picker clearable
            v-model="form.controlStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择管制开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="管制结束时间" prop="controlEndTime">
          <el-date-picker clearable
            v-model="form.controlEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择管制结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="管制路段" prop="controlLocation">
          <el-select v-model="form.controlLocation" placeholder="请选择交通管制路段">
            <el-option
              v-for="dict in dict.type.location"
              :key="dict.value"
              :label="dict.label"
              :value="dict.label"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="管制原因" prop="controlReason">
          <el-input v-model="form.controlReason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="数据来源" prop="deptId">
          <el-select v-model="form.deptId" placeholder="请选择提供数据部门">
            <el-option
              v-for="dict in dict.type.dept_id"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTrafficcontrol, getTrafficcontrol, delTrafficcontrol, addTrafficcontrol, updateTrafficcontrol } from "@/api/road/trafficcontrol";

export default {
  name: "Trafficcontrol",
  dicts: ['dept_id','location'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedDept: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 交通管制数据管理表格数据
      trafficcontrolList: [],
      // 高速公路相关部门管理表格数据
      deptList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        controlStartTime: null,
        controlEndTime: null,
        controlReason: null,
        controlLocation: null,
        updatedAt: null,
        deptId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询交通管制数据管理列表 */
    getList() {
      this.loading = true;
      listTrafficcontrol(this.queryParams).then(response => {
        this.trafficcontrolList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        controlStartTime: null,
        controlEndTime: null,
        controlReason: null,
        updatedAt: null,
        deptId: null
      };
      this.deptList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加交通管制数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTrafficcontrol(id).then(response => {
        this.form = response.data;
        this.deptList = response.data.deptList;
        this.open = true;
        this.title = "修改交通管制数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.deptList = this.deptList;
          if (this.form.id != null) {
            updateTrafficcontrol(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTrafficcontrol(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除第"' + ids + '"号数据项？').then(function() {
        return delTrafficcontrol(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 高速公路相关部门管理序号 */
    rowDeptIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 高速公路相关部门管理添加按钮操作 */
    handleAddDept() {
      let obj = {};
      obj.parentId = "";
      obj.deptName = "";
      obj.leader = "";
      obj.phone = "";
      obj.email = "";
      obj.status = "";
      obj.createdBy = "";
      this.deptList.push(obj);
    },
    /** 高速公路相关部门管理删除按钮操作 */
    handleDeleteDept() {
      if (this.checkedDept.length == 0) {
        this.$modal.msgError("请先选择要删除的高速公路相关部门管理数据");
      } else {
        const deptList = this.deptList;
        const checkedDept = this.checkedDept;
        this.deptList = deptList.filter(function(item) {
          return checkedDept.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleDeptSelectionChange(selection) {
      this.checkedDept = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('road/trafficcontrol/export', {
        ...this.queryParams
      }, `trafficcontrol_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
