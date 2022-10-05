<template>
  <div class="display-announce">
    <h2 class="top-text">Latest School Announcements:</h2>
    <div id="scroll-container">
      <div id="scroll-text">
        <p>{{ this.$store.state.latestAnnouncement.message }}</p>
        <p>Date: {{ this.$store.state.latestAnnouncement.timeStamp }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import AdminService from "../services/AdminService";
export default {
  data() {
    return {};
  },
  methods: {
    getLatestAnnouncement() {
      AdminService.getLatestAnnouncement().then((response) => {
        this.$store.commit("SET_LATEST_ANNOUNCEMENT", response.data);
      });
      // .catch((error) => {
      //     if (error.response.status == 404){
      //         this.$router.push({name: "NotFound"});
      //     }
      // });
    },
  },
  created() {
    this.getLatestAnnouncement();
  },
};
</script>

<style>
.display-announce {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.657);
}
.top-text {
  display: grid;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
}
p {
  display: grid;
  align-content: center;
  justify-content: center;
  text-decoration-color: black;
}
#scroll-container {
  background-color: white;
  border: 3px solid black;
  border-radius: 5px;
  overflow: hidden;
}

#scroll-text {
  /* animation properties */

  -moz-transform: translateX(100%);
  -webkit-transform: translateX(100%);
  transform: translateX(100%);

  -moz-animation: my-animation 15s linear infinite;
  -webkit-animation: my-animation 15s linear infinite;
  animation: my-animation 15s linear infinite;
}

/* for Firefox */
@-moz-keyframes my-animation {
  from {
    -moz-transform: translateX(100%);
  }
  to {
    -moz-transform: translateX(-100%);
  }
}

/* for Chrome */
@-webkit-keyframes my-animation {
  from {
    -webkit-transform: translateX(100%);
  }
  to {
    -webkit-transform: translateX(-100%);
  }
}

@keyframes my-animation {
  from {
    -moz-transform: translateX(100%);
    -webkit-transform: translateX(100%);
    transform: translateX(100%);
  }
  to {
    -moz-transform: translateX(-100%);
    -webkit-transform: translateX(-100%);
    transform: translateX(-100%);
  }
}
</style>