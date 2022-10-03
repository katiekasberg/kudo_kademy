<template>
  <div>
        <h1>Staff Profile</h1>
        <div>
            <p id="first-name">First Name: {{ this.$store.state.activeStaffProfile.firstName }} </p>
            <p id="last-name">Last Name: {{ this.$store.state.activeStaffProfile.lastName }} </p>
            <p id="school">School: {{ this.$store.state.activeStaffProfile.schoolId }} </p>
            <p id="graduation-year">Class Of: {{ this.$store.state.activeStaffProfile.graduationYear }} </p>
            <p id="email">Email Address: {{ this.$store.state.activeStaffProfile.email }} </p>
            <img v-bind:src="this.$store.state.activeStaffProfile.image"/>
        </div>
  </div>
</template>

<script>
import TeacherService from '../services/TeacherService'
export default {
  name: 'StaffDetail',
  props: {
    staffId: Number
  },
  data() {
    return {

    };
  },
  methods: {
    getStaffProfile(){
      TeacherService.getStaffProfile(this.staffId).then((response) => {
        this.$store.commit("SET_ACTIVE_STAFF_PROFILE", response.data)
      })
      .catch(error => {
            if(error.response.status == 404){
                this.$router.push({name: 'NotFound'});
            }
      });
    },
  },

  created(){
    this.getStaffProfile();
  }


}
</script>

<style>

</style>