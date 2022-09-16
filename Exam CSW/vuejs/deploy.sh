set -e
sudo systemctl stop nginx.service
yarn build
sudo rm -rf /usr/share/nginx/html/
sudo cp -R ./dist/ /usr/share/nginx/html/
sudo systemctl start nginx.service
echo done
