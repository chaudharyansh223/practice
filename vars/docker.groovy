def call(image_version) {
  def dockercontent = """
  FROM ${image_version}
  RUN apt-get update;apt-get install tree -y
  CMD ["tree", "--version"]
  WORKDIR /tmp/
  """
  // writeFile(file: 'Dockerfile', text: dockercontent)
  sh "docker build -t jenkins:2 ."
  sh "docker container run -d jenkins:2"
}
    
