<template>
  <div class="container">
    <body>
      <h1>SCHOOL COMMUNICATION</h1>
      <img class="logo" src="../../resources/school-icon-9.png" alt="" />
      <nav class="sidebar">
        <button router-link:on="../teacher">Home</button>
        <button href="/SendKudos">Send Kudos</button>
        <button>Behavioral Report</button>
        <button>Search Students</button>
        <button>Classes</button>
      </nav>
      <student-list class="student-list" />
      <h2>House Cup Leader Board</h2>

      <table></table>
    </body>
  </div>
</template>

<script>
import StudentList from "../components/StudentList";
export default {
  components: {
    StudentList,
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
nav {
  justify-content: flex-start;
  flex-direction: column;
  align-items: left;
}
button {
  margin-bottom: 20px;
}
student-list {
  display: grid;
  align-items: center;
  justify-content: center;
}
.container {
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "header header header"
    "sidebar content content"
    "footer footer footer";
  background-color: rgb(253, 223, 158);
}
.sidebar {
  flex-direction: column;
  align-items: left;
}
button {
  padding: 10px;
  margin-left: 20px;
  background-color: rgb(253, 223, 158);
  border-radius: 10%;
  border-color: orange;
}
.student-list {
  align-items: center;
  justify-content: center;
}
</style>
  