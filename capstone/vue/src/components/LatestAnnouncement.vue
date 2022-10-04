<template>
  <div>
      <h2>Latest School Announcement</h2>
      <p>{{this.$store.state.latestAnnouncement.message}}</p>
      <p>Date: {{this.$store.state.latestAnnouncement.timeStamp}}</p>
  </div>
</template>

<script>
import AdminService from '../services/AdminService';
export default {
    data(){
        return {

        };
    },
    methods: {
        getLatestAnnouncement() {
            AdminService.getLatestAnnouncement().then((response) => {
                this.$store.commit("SET_LATEST_ANNOUNCEMENT", response.data);
            })
            // .catch((error) => {
            //     if (error.response.status == 404){
            //         this.$router.push({name: "NotFound"});
            //     }
            // });
        },
    },
    created() {
        this.getLatestAnnouncement();
    }
}
</script>

<style>

</style>