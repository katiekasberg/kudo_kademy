<template>
  <div>
    <h1>Staff Profile</h1>
    <div class="layout">
      <div class="info">
        <br />

        <p id="first-name">
          First Name: {{ this.$store.state.activeStaffProfile.firstName }}
        </p>
        <br />
        <p id="last-name">
          Last Name: {{ this.$store.state.activeStaffProfile.lastName }}
        </p>
        <br />
        <p id="email">
          Email Address: {{ this.$store.state.activeStaffProfile.email }}
        </p>
      </div>
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
.layout {
  display: flex;
  flex-direction: row;
}
.info {
  display: flex;
  flex-direction: column;
  height: 150px;
  margin: 20px;
}

img {
  border-radius: 50%;
  justify-content: right;
  align-items: right;
  height: 200px;
  width: 200px;
  image-rendering: auto;
  padding-top: 50px;
}
</style>