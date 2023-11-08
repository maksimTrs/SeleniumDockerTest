# To execute this docker-compose yml file use `docker-compose -f docker-compose-v3-video.yml up`

# Add the `-d` flag at the end for detached execution

# To stop the execution, hit Ctrl+C, and then `docker-compose -f docker-compose-v3-video.yml down`

# docker compose  -f docker-compose-v3-video.yml up --scale chrome=2 --scale firefox=2
to scale browser and video nodes

http://localhost:4444/ui#  -> UI with nodes

http://localhost:7902/  -> noVnc UI for firefox (if was activated -> working only for 1 node)

http://localhost:7900/  -> noVnc UI for chrome (if was activated -> working only for 1 node)