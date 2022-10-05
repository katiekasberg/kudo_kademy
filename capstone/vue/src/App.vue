<template>
  <body>
    <div id="nav">
      <nav-bar />
    </div>
    <div id="app">
      <h1>School Communication</h1>
      <img
        class="logo"
        src="../resources/school-icon-9.png"
        alt="school-logo"
      />
      <router-view />
    </div>
  </body>
</template>

<script>
import NavBar from "./components/NavBar.vue";

export default {
  components: { NavBar },
};
</script>

<style scoped>
#app {
  background-color: white;
  display: grid;
  align-content: center;
  justify-content: center;
}
h1 {
  display: grid;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  align-content: center;
  justify-content: center;
}
img {
  display: grid;
  padding-left: 550px;
  height: 150px;
  width: auto;
}

.nav {
  display: inline-flex;
  float: left;
  align-content: flex-start;
  align-items: flex-start;
  justify-content: flex-start;
  justify-items: flex-start;
}
a {
  text-decoration: none;
  color: black;
  opacity: 100%;
  font-weight: bold;
}
</style>
