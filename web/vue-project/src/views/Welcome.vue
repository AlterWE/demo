<template>
  <div class="welcome-container">
    <h1>欢迎，{{ userName }}</h1>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import {useRoute} from 'vue-router';

const route = useRoute();
const userName = ref('');

onMounted(() => {
  // 从路由参数获取用户名
  userName.value = route.query.name || '未知用户';
});
</script>

<style scoped>

</style>