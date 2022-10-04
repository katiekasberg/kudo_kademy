<template>
  <body>
    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <label for="firstName" class="sr-only"
          >First Name:
          <input
            type="text"
            id="firstName"
            class="form-control"
            placeholder="First Name"
            v-model="profile.firstName"
            required
            autofocus
          />
        </label>

        <label for="lastName" class="sr-only"
          >Last Name:
          <input
            type="text"
            id="lastName"
            class="form-control"
            placeholder="Last Name"
            v-model="profile.lastName"
            required
            autofocus
          />
        </label>

        <label for="emailAddress" class="sr-only"
          >Email Address:
          <input
            type="text"
            id="emailAddress"
            class="form-control"
            placeholder="Email Address"
            v-model="profile.email"
            required
            autofocus
          />
        </label>

        <label for="username" class="sr-only"
          >Username:
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </label>
        <label for="password" class="sr-only"
          >Password:
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </label>
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />

        <label for="roleMenu" class="sr-only"
          >Role:
          <select
            name="role-names"
            id="role-names"
            v-model="user.role"
            required
          >
            <option value="parent">Parent</option>
            <option value="student">Student</option>
            <option value="teacher">Teacher</option>
            <option value="admin">Administrator</option>
          </select>
        </label>

        <label for="school-id" class="sr-only" v-if="user.role === 'student'"
          >Choose your school:
          <select
            name="school-id"
            id="school-id"
            v-model="student.schoolId"
            required
          >
            <option value="1">Cypress Hill Middle School</option>
            <option value="2">Cypress Hill High School</option>
          </select>
        </label>

        <label
          for="graduation-year"
          class="sr-only"
          v-if="user.role === 'student'"
          >Graduation Year:
          <input
            type="text"
            id="graduation-year"
            class="form-control"
            placeholder="Graduation Year"
            v-model="student.graduationYear"
            required
            autofocus
          />
        </label>

        <label for="phone-number" class="sr-only" v-if="user.role === 'parent'"
          >Phone Number:
          <input
            type="text"
            id="phone-number"
            class="form-control"
            placeholder="Phone Number"
            v-model="parent.phoneNumber"
            required
            autofocus
          />
        </label>

        <label for="address" class="sr-only" v-if="user.role === 'parent'"
          >Address:
          <input
            type="text"
            id="address"
            class="form-control"
            placeholder="Address"
            v-model="parent.address"
            required
            autofocus
          />
        </label>

        <router-link :to="{ name: 'login' }">Have an account?</router-link>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Create Account
        </button>
      </form>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "",
      },
      profile: {
        id: Number,
        firstName: "",
        lastName: "",
        email: "",
      },
      student: {
        id: Number,
        schoolId: Number,
        graduationYear: Number,
      },
      parent: {
        id: Number,
        phoneNumber: "",
        address: "",
      },

      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.profile.id = response.data;
              authService.createProfile(this.profile).then((response) => {
                if (response.status == 201 && this.user.role === "student") {
                  this.student.id = this.profile.id;
                  authService.createStudent(this.student).then((response) => {
                    if (response.status == 201) {
                      this.$router.push({
                        path: "/login",
                        query: { registration: "success" },
                      });
                    }
                  });
                } else if (
                  response.status == 201 &&
                  this.user.role === "parent"
                ) {
                  this.parent.id = this.profile.id;
                  authService.createParent(this.parent).then((response) => {
                    if (response.status == 201) {
                      this.$router.push({
                        path: "/login",
                        query: { registration: "success" },
                      });
                    }
                  });
                } else {
                  this.$router.push({
                    path: "/login",
                    query: { registration: "success" },
                  });
                }
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.form-register {
  display: grid;
  align-items: center;
  justify-content: center;
  grid-gap: 18px;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 22pt;
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
  letter-spacing: 2px;
}
.form-control {
  float: right;
  width: auto;
  height: auto;
}
#confirmPassword {
  width: 200px;
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
  color: darkorange;
  text-decoration: underline;
  text-shadow: 1px 0px 0px black, -1px 0px 0px black, 0px 1px 0px black,
    0px -1px 0px black;
  letter-spacing: 2px;
}

#register {
  margin-left: 25%;
  margin-right: 25%;
  background-color: rgba(255, 255, 255, 0.616);
}

.sr-only {
  color: darkorange;
}
button {
  height: 150%;
}
body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
</style>