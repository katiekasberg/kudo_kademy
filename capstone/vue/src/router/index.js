import Vue from 'vue'
import Router from 'vue-router'
import EditKudoType from '../views/EditKudoType.vue'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Teacher from '../views/Teacher.vue'
import SendKudos from '../views/SendKudos.vue'
import Admin from '../views/Admin.vue'
import Parent from '../views/Parent.vue'
import Student from '../views/Student.vue' 
import StudentProfile from '../views/StudentProfile.vue'
import NotFound from '../views/NotFound.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/teacher",
      name: "teacher",
      component: Teacher,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/SendKudos",
      name: "SendKudos",
      component: SendKudos,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/edit-kudo-type/:id",
      name: "EditKudoType",
      component: EditKudoType,
      meta: {
        requiresAuth: false
      }
    },

    {
      path: "/admin",
      name: "admin",
      component: Admin,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/notfound",
      name: "NotFound",
      component: NotFound,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/parent",
      name: "parent",
      component: Parent,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/student-profile/:id",
      name: "StudentProfile",
      component: StudentProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/student/",
      name: "student",
      component: Student,
      meta: {
        requiresAuth: true
      }
    },

  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
