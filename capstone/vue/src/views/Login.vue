<template>
  <body>
    <div id="login" class="text-center">
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
  </body>
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
            console.log(response.data.user);
            if (response.data.user.authorities[0].name == "ROLE_PARENT") {
              this.$router.push({ name: "parent" });
            } else if (
              response.data.user.authorities[0].name == "ROLE_TEACHER"
            ) {
              this.$router.push({ name: "teacher" });
            } else if (response.data.user.authorities[0].name == "ROLE_ADMIN") {
              this.$router.push({ name: "admin" });
            } else {
              this.$store.commit(
                "SET_ACTIVE_STUDENT_ID",
                response.data.user.id
              );
              this.$router.push({ name: "student" });
            }
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
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
  letter-spacing: 2px;
}
.form-control {
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
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
  letter-spacing: 2px;
}
#login {
  margin-left: 25%;
  margin-right: 25%;
  background-color: rgba(255, 255, 255, 0.616);
}
body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );

  display: 100%;
}
.sr-only {
  color: darkorange;
}
button {
  width: 100%;
  height: 150%;
}
</style>