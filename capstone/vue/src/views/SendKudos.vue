<template>
  <div>
    <h1>SCHOOL COMMUNICATION</h1>
    <img class="logo" src="../../resources/school-icon-9.png" alt="" />

    <h2 class="h3 mb-3 font-weight-normal">Send A Kudo!</h2>

    <form action="submit">
      <label for="StudentId">Student Id:</label><br />
      <input type="text" id="StudentId" name="StudentId" /><br />
      <input type="radio" id="KudosTypeA" name="KudosType" />
      <label for="KudosTypeA">Kudos Type A</label><br />
      <input type="radio" id="KudosTypeB" name="KudosType" />
      <label for="KudosTypeB">Kudos Type B</label><br />
      <input type="radio" id="KudosTypeC" name="KudosType" />
      <label for="KudosTypeC">Kudos Type C</label><br />
      <input type="radio" id="KudosTypeD" name="KudosType" />
      <label for="KudosTypeD">Kudos Type D</label><br />
      <label for="Comments">Comments:</label><br />
      <input type="text" id="Comments" name="Comments" /><br />
      <button>Send</button>
    </form>
  </div>
</template>

  <script></script>
    <style scoped>
.send-kudo {
  display: grid;
  align-items: center;
  justify-content: center;
  grid-gap: 7px;
}
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
form {
  display: grid;
  grid-area: auto;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  margin: 10px;
}
label {
  float: left;
  clear: none;
  display: block;
  padding: 0px 0em 0px 20px;
}

input[type="radio"],
input.radio {
  float: left;
  clear: none;
  margin: 0px 200px 0px 0px;
}
</style>
  
