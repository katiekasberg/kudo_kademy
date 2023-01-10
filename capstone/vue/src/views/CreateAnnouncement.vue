<template>
  <body>
    <div class="Announcements">
      <form v-on:submit.prevent action="submit">
        <h3>Create an Announcement</h3>
        <input
          type="text"
          id="makeAnnouncement"
          placeholder="Enter Announcement"
          v-model="newAnnouncement.message"
        />
        <br />
        <button type="submit" v-on:click="saveAnnouncement()" class="submitBtn">
          Submit
        </button>
      </form>
    </div>
  </body>
</template>

<script>
import AdminService from "../services/AdminService";

export default {
  data() {
    return {
      newAnnouncement: {
        message: "",
      },
    };
  },
  methods: {
    saveAnnouncement() {
      AdminService.createAnnouncement(this.newAnnouncement).then((response) => {
        if (response.status === 201) {
          this.newAnnouncement.message = "";

          if (this.$store.state.user.authorities[0].name == "ROLE_TEACHER") {
            this.$router.push({ name: "teacher" });
          } else if (
            this.$store.state.user.authorities[0].name == "ROLE_ADMIN"
          ) {
            this.$router.push({ name: "admin" });
          }
        }
      });
    },
  },
};
</script>


<style scoped>
.Announcements {
  justify-content: center;
  align-content: center;
}
body {
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
  padding-bottom: 300px;
  margin-top: 100px;
}
input {
  padding: 100px;
  padding-left: 300px;
  padding-right: 300px;
  border-radius: 5px;
}
</style>