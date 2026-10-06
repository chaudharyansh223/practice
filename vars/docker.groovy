def call(image_version) {
  def dockercontent = """
  FROM ${image_version}
  RUN apt-get update;apt-get install tree -y
  CMD ["tree", "--version"]
  """
  writeFile(file: 'Dockerfile', text: dockercontent)
            sh "docker build -t jenkins:1 ."
}
    
