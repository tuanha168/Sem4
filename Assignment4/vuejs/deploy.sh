set -e
yarn build
sudo rm -rf /usr/share/nginx/html/
sudo cp -R ./dist/ /usr/share/nginx/html/
sudo systemctl restart nginx.service
echo done
