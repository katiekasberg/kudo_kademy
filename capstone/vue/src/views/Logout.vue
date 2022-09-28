<template>
<div>
  <img src="../../resources/school-icon-9.png" alt="school-logo" />
  <h1>Logout</h1>

</div>
  

</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>
