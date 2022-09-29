<template>
  <div id="login" class="text-center">
    <h1>SCHOOL COMMUNICATION</h1>
    <img
      class="logo"
      src="../../resources/school-icon-9.png"
      alt="school-logo"
    />
    <form class="form-signin" @submit.prevent="login">
      <h2 class="h3">Welcome!!!</h2>
      <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style scoped>
.form-signin {
  display: grid;
  align-items: center;
  justify-items: center;
  justify-content: center;
  grid-gap: 18px;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 22pt;
   text-shadow: 1px 0px 0px black,
  -1px 0px 0px black,
  0px 1px 0px black,
  0px -1px 0px black;
  letter-spacing: 2px;
}
.form-control{
  display: grid;
  width: 100%;
  height: 150%;
}
img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto; 
}

h1 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: rgb(223, 126, 8);
  text-decoration: underline;
  text-shadow: 
  1px 0px 0px black,
  -1px 0px 0px black,
  0px 1px 0px black,
  0px -1px 0px black;
  letter-spacing: 2px;
}
#login{
  background: linear-gradient(360deg,white 0%, #FFC93C 10%, #FF9A3C 30%, #FF6F3C, #155263 90%);
  display: 100%;
}
.sr-only{
  color: darkorange;
}
button{
  width: 100%;
  height: 150%;
}
</style>