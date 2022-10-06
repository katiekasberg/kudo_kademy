<template>
  <div class="box">
    <h1>Staff Profile</h1>
    <div>
      <p id="first-name">
        First Name: {{ this.$store.state.activeStaffProfile.firstName }}
      </p>
      <p id="last-name">
        Last Name: {{ this.$store.state.activeStaffProfile.lastName }}
      </p>
      <p id="email">
        Email Address: {{ this.$store.state.activeStaffProfile.email }}
      </p>
      <img v-bind:src="this.$store.state.activeStaffProfile.image" />
    </div>
  </div>
</template>

<script>
import TeacherService from "../services/TeacherService";
export default {
  name: "StaffDetail",
  props: {
    staffId: Number,
  },
  data() {
    return {};
  },
  methods: {
    getStaffProfile() {
      TeacherService.getStaffProfile(this.staffId)
        .then((response) => {
          this.$store.commit("SET_ACTIVE_STAFF_PROFILE", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });
    },
  },

  created() {
    this.getStaffProfile();
  },
};
</script>

<style scoped>
.student-profile {
  display: grid;
  justify-content: center;
}

img {
  display: grid;
  width: 50%;
  justify-items: center;
  justify-content: center;

}
.box {
  background-color: rgba(255, 255, 255, 0.657);
}
img {
  border-radius: 50%;
  justify-content: center;
  align-items: center;
  margin-left: 50px;
  height: 200px;
  width: 200px;
  image-rendering: auto;
}
</style>