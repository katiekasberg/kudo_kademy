<template>
  <div class="container">
    <div id="profile-image">
          <img v-bind:src="this.$store.state.activeParentProfile.image" />
    </div>
    <div class="parent-profile">
      <h1>Parent Profile</h1>
      <div id="profileInfo">
        <p id="first-name">
          First Name: {{ this.$store.state.activeParentProfile.firstName }}
        </p>
        <p id="last-name">
          Last Name: {{ this.$store.state.activeParentProfile.lastName }}
        </p>
        <p id="phone-number">
          Phone Number: {{ this.$store.state.activeParentProfile.phoneNumber }}
        </p>
        <p id="address">
          Address: {{ this.$store.state.activeParentProfile.address }}
        </p>
        <p id="email">
          Email: {{ this.$store.state.activeParentProfile.email }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import ParentService from "../services/ParentService";

export default {
    name: 'ParentDetail',
    props: {
        parentId: Number,
    },
    data(){
        return {

        };
    },
    methods: {
        getParentProfile(){
            ParentService.getParentProfile(this.parentId).then((response) => {
                this.$store.commit("SET_ACTIVE_PARENT_PROFILE", response.data);
            })
            .catch((error) => {
                if(error.response.status == 404){
                    this.$router.push({name: "NotFound"});
                }
            });
        }
    },
    created(){
        this.getParentProfile();
    }

}
</script>

<style>

</style>