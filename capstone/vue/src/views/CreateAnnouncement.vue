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
        <button type="submit" v-on:click="saveAnnouncement()" class="submitBtn">Submit</button>
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
          
          if ( this.$store.state.user.authorities[0].name == "ROLE_TEACHER" ) {
            this.$router.push({ name: "teacher" });
          } else if ( this.$store.state.user.authorities[0].name == "ROLE_ADMIN" ) {
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
  background-color: white;
}
body {
  grid-area: Announcements;
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  margin: auto;
  display: block;
  width: 50%;
  height: 50%;
  text-align: center;
  padding-bottom: 100px;
  margin-left: 300px;
  margin-top: 200px;

  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
input {
  padding: 100px;
}
</style>