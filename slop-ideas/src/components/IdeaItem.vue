<script setup>
const props = defineProps({ idea: String })

function getRandomArbitrary(min, max) {
  return Math.random() * (max - min) + min
}
function getRandomColor() {
  switch (Math.floor(Math.random() * 16)) {
    case 0:
      return 'var(--cyan-dark)'
      break
    case 1:
      return 'var(--cyan-mid-dark))'
      break
    case 2:
      return 'var(--cyan)'
      break
    case 3:
      return 'var(--cyan-mid-light)'
      break
    case 4:
      return 'var(--cyan-light)'
      break
    case 5:
      return 'var(--blue-dark)'
      break
    case 6:
      return 'var(--blue-mid-dark)'
      break
    case 7:
      return 'var(--blue)'
      break
    case 8:
      return 'var(--blue-mid-light)'
      break
    case 9:
      return 'var(--blue-light)'
      break
    case 10:
      return 'var(--red-dark)'
      break
    case 11:
      return 'var(--red-mid-dark)'
      break
    case 12:
      return 'var(--red)'
      break
    case 13:
      return 'var(--red-light)'
      break
    case 14:
      return 'var(--orange-dark)'
      break
    case 15:
      return 'var(--orange-mid-dark)'
      break
    case 16:
      return 'var(--orange-light)'
      break

    default:
      return 'var(--blue)'
      break
  }
}
const rotation = getRandomArbitrary(-90, 90) + 'deg'
const randomMargin = `${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)}, ${getRandomArbitrary(0, 20)},`
const randomWidth = `${getRandomArbitrary(64, 256)}px`
const randomBorderTop = `${getRandomArbitrary(0, 20)}px groove var(--red)`
const randomBorderRight = `${getRandomArbitrary(0, 20)}px inset var(--red)`
const randomBorderBottom = `${getRandomArbitrary(0, 20)}px outset var(--red)`
const randomBorderLeft = `${getRandomArbitrary(0, 20)}px ridge var(--red)`
const randomColor = getRandomColor()
const styleObject = {
  rotate: rotation,
  margin: randomMargin,
  width: randomWidth,
  color: randomColor,
  textShadow: `0px 0px 7px var(--cyan)`
  // borderTop: randomBorderTop,
  // borderRight: randomBorderRight,
  // borderBottom: randomBorderBottom,
  // borderLeft: randomBorderLeft,
}
const onClick = () => {

}
</script>

<template>
  <li class="IdeaItem" :style="styleObject" >
    <h3 class="IdeaItem-Name" :title=props.idea>
      {{ props.idea }}
    </h3>
  </li>
</template>
<style>
.IdeaItem {
  margin: 0;
  max-width: 100%;
  text-align: center;
  padding: 8px 32px;
  overflow: visible;
}
.IdeaItem-Name {
  cursor: pointer;
}
</style>
