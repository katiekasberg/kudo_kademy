<template>
  <body>
    <div>
      <new-kudos />
    </div>
  </body>
</template>

  <script>
import NewKudos from "../components/NewKudos";
export default {
  components: {
    NewKudos,
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
body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
new-kudos {
  padding-bottom: 200px;
}
</style>
  