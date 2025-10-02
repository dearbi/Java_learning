//1.定义路由表
import Home from "../views/Home.vue";
import Hello from "../views/Hello.vue";
import Haha from "../views/Haha.vue";
import {createMemoryHistory, createRouter} from "vue-router";

const routes = [
  {
    path: '/',
    component: Home
  },
  {
    path: '/hello',
    component: Hello
  },
  {
    path: '/haha',
    component: Haha
  }
]
//2.配置路由表
const router = createRouter({
    history: createMemoryHistory(),
    routes,
});
//3.导出路由表
export default router;
//4.在vue实例中挂载路由
