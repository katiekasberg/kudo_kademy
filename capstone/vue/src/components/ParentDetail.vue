<template>
  <div>
    <h1>Parent Profile</h1>
    <div class="layout">
      <div id="info">
        <br />
        <p id="first-name">
          First Name: {{ this.$store.state.activeParentProfile.firstName }}
        </p>
        <p id="last-name">
          Last Name: {{ this.$store.state.activeParentProfile.lastName }}
        </p>
        <p id="phone-number">
          Phone Number:
          {{ this.$store.state.activeParentProfile.phoneNumber }}
        </p>
        <p id="address">
          Address: {{ this.$store.state.activeParentProfile.address }}
        </p>
        <p id="email">
          Email: {{ this.$store.state.activeParentProfile.email }}
        </p>
      </div>
      <img v-bind:src="this.$store.state.activeParentProfile.image" />
    </div>
  </div>
</template>

<script>
import ParentService from "../services/ParentService";

export default {
  name: "ParentDetail",
  props: {
    parentId: Number,
  },
  data() {
    return {};
  },
  methods: {
    getParentProfile() {
      ParentService.getParentProfile(this.parentId)
        .then((response) => {
          this.$store.commit("SET_ACTIVE_PARENT_PROFILE", response.data);
        })
        .catch((error) => {
          if (error.response.status == 404) {
            this.$router.push({ name: "NotFound" });
          }
        });
    },
  },
  created() {
    this.getParentProfile();
  },
};
</script>

<style scoped>
.layout {
  display: flex;
  flex-direction: row;
  padding-left: 150px;
  padding-bottom: 100px;
}
.info {
  display: flex;
  flex-direction: column;
  height: 150px;
  padding-top: 100px;
  margin: 100px;
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