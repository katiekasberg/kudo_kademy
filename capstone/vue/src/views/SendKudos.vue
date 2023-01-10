<template>
  <body>
    <div>
      <new-kudos />
      <rewards />
    </div>
  </body>
</template>

  <script>
import NewKudos from "../components/NewKudos";
import Rewards from "../components/Rewards.vue";
export default {
  components: {
    NewKudos,
    Rewards,
  },
};
</script>
  <style scoped>
img.logo {
  grid-area: "header";
  margin-bottom: 0;
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}

h1 {
  display: grid;
  grid-area: header;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
}
h2 {
  display: grid;
  grid-area: left;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
}

new-kudos {
  padding-bottom: 200px;
}
</style>
  