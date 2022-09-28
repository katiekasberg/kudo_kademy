<template>
  <div>
    <body>
      <h1>SCHOOL COMMUNICATION</h1>
      <img class="logo" src="../../resources/school-icon-9.png" alt="" />
      <nav>
        <button router-link:on="../teacher">Home</button>
        <button href="/SendKudos">Send Kudos</button>
        <button>Behavioral Report</button>
        <button>Search Students</button>
        <button>Classes</button>
      </nav>
      <h2>House Cup Leader Board</h2>
      <table></table>
    </body>
  </div>
</template>
<script></script>
    <style scoped>
img.logo {
  margin: auto;
  display: block;
  width: 200px;
  height: auto;
}

h1 {
  display: grid;
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
  display: grid;
  align-items: right;
  grid-area: right;
  margin-right: 2000px;
}
button {
  margin-bottom: 20px;
}
</style>
  