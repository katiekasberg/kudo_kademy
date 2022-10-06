<template>
  <body class="back-opaque">
    <div class="nav">
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

<style>
#app {
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

a {
  text-decoration: none;
  color: black;
  opacity: 100%;
  font-weight: bold;
}
.logo {
  display: grid;
  justify-content: center;
  height: 150px;
  width: auto;
  margin: auto;
}

.back-opaque {
  background: linear-gradient(
    360deg,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white,
    white,
    white,
    white,
    white
  );
  background-attachment: fixed;
  font-family: Arial, Helvetica, sans-serif;
  font-size: medium;
  position: relative;
  z-index: 1;
  padding-bottom: 300px;
  margin: 0;
  padding: 0;
}
.back-opaque:before {
  z-index: -1;
  position: absolute;
  height: 25%;
  content: url(../resources/dis-pretty-schoo.png);
  opacity: 0.2;
  background-image: no-repeat;
}
</style>
