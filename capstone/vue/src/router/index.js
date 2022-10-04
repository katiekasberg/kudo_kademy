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
import AdminProfile from '../views/AdminProfile.vue'
import Parent from '../views/Parent.vue'
import Student from '../views/Student.vue'
import StudentProfile from '../views/StudentProfile.vue'
import ParentProfile from '../views/ParentProfile.vue'
import TeacherProfile from '../views/TeacherProfile.vue'
import NotFound from '../views/NotFound.vue'
import Rewards from '../views/Rewards.vue'
import SearchByStudent from "../views/SearchByStudent"
import NewKudoType from "../components/NewKudoType"
import CreateAnnouncement from "../views/CreateAnnouncement"
import CreateClass from "../views/CreateClass"
import ClassManagement from '../views/ClassManagement'

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
        requiresAuth: false
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
        requiresAuth: true
      }
    },
    {
      path: "/SendKudos",
      name: "SendKudos",
      component: SendKudos,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/edit-kudo-type/:id",
      name: "EditKudoType",
      component: EditKudoType,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/admin",
      name: "admin",
      component: Admin,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/notfound",
      name: "NotFound",
      component: NotFound,
      meta: {
        requiresAuth: false
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
      path: "/parent-profile/:id",
      name: "ParentProfile",
      component: ParentProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/admin-profile/:id",
      name: "AdminProfile",
      component: AdminProfile,
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
      path: "/teacher-profile/:id",
      name: "TeacherProfile",
      component: TeacherProfile,
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
    {
      path: "/rewards",
      name: "rewards",
      component: Rewards,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/searchbystudent",
      name: "searchbystudent",
      component: SearchByStudent,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/newkudotype",
      name: "newkudotype",
      component: NewKudoType,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/newclass",
      name: "newClass",
      component: CreateClass,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/createannouncement",
      name: "createannouncement",
      component: CreateAnnouncement,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/manage-classes",
      name: "manage-classes",
      component: ClassManagement,
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
