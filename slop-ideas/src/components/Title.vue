<script setup lang="ts"></script>
<template>
  <h1 class="Title">Simon's Idea Machine</h1>
  <nav class="TitleNav">
    <RouterLink to="/" class="TitleNavLink">Groups</RouterLink>
    <RouterLink to="/pairs" class="TitleNavLink">Pairs</RouterLink>
  </nav>
</template>
<style>
.Title {
  font-family: laff-riot-nf-font;
  font-size: 72px;
  background-color: var(--orange);
  border: 24px solid var(--blue);
  color: var(--blue);
  margin: auto;
  width: 480px;
  text-align: center;
  font-weight: 900;
  transform: skew(12deg);
}
.TitleNav {
  display: flex;
  justify-content: center;
  margin: 8px 0 32px 32px;
}
.TitleNavLink {
  font-family: laff-riot-nf-font;
  background-color: var(--orange);
  color: var(--blue);
  border: none;
  border-radius: 128px 256px;
  font-size: 48px;
  font-weight: 900;
  padding: 8px 16px;
}
.TitleNavLink:hover {
  color: var(--orange);
  background-color: var(--blue);
}
.TitleNavLink:active {
  background-color: var(--orange) !important;
  color: var(--blue) !important;
}
</style>
