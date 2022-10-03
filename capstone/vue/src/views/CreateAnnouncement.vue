<template>
  <body>
    <div class="Announcements">
      <h3>Create an Announcement</h3>
      <input
        type="text"
        id="makeAnnouncement"
        placeholder="Enter Announcement"
      />
      <button type="submit" class="submitBtn">Submit</button>
    </div>
  </body>
</template>
<style scoped>
.Announcements {
  background-color: white;
}
body {
  grid-area: Announcements;
  color: black;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
  margin: auto;
  display: block;
  width: 50%;
  height: 50%;
  text-align: center;
  padding-bottom: 100px;
  margin-left: 300px;
  margin-top: 200px;

  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
input {
  padding: 100px;
}
</style>