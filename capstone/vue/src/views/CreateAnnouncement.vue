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
        if (response.data === 201) {
          this.newAnnouncement.message = "";
        }
      });
    },
  },
};
</script>


<style scoped>
.Announcements {
  background-color: rgba(255, 255, 255, 0.616);
  justify-content: center;
  align-content: center;
  padding-right: 1200px;
  padding-left: 900px;
}
body {
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;

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
  padding-left: 300px;
  padding-right: 300px;
}
form {
  padding-bottom: 500px;
}
</style>