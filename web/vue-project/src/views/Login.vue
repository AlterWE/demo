<template>
  <div class = "login-container">
    <el-form ref="loginForm" :model="form" :rules="rules" @submit.prevent="login" style="text-align: center">
      <h3>XXX系统</h3>
      <el-form-item prop="username" label="账号" label-width="80px" style="width: 300px">
        <el-input v-model="form.username" placeholder="请输入账号" />
      </el-form-item>
      <el-form-item prop="password" label="密码" label-width="80px" style="width: 300px">
        <el-input v-model="form.password" type="password" placeholder="请输入密码" show-password />
      </el-form-item>
      <el-button type="primary" native-type="submit">登录</el-button>
    </el-form>
  </div>
</template>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;

}
</style>

<script setup>
import {reactive, ref} from 'vue'
import axios from 'axios'
import {ElMessage} from "element-plus";
import router from "@/router/index.js";

const loading = ref(false)
const loginForm = ref(null)

const form = reactive({
  username: '',
  password: ''
})

const rules = reactive({
  username: [
    { required: true, message: '请输入账号', trigger: 'blur' },
    { min: 4, max: 16, message: '长度在4到16个字符', trigger: 'blur' }
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
    { min: 6, max: 20, message: '长度在6到20个字符', trigger: 'blur' }
  ]
})

const login = async () => {
  await loginForm.value.validate()

  loading.value = true

  const response = await axios.post('/api/api/login', {
    username: form.username,
    password: form.password
  })

  if (response.status >= 200 && response.status < 300) {
    ElMessage.success('登录成功');
    localStorage.setItem('token', response.data.token);
    router.push({
      path: '/welcome',
      query: { name: response.data.data.name }
    });
  } else {
    const errorMsg = response.data.message || `请求失败（状态码: ${response.status}）`;
    ElMessage.error(errorMsg);
  }
}
</script>
